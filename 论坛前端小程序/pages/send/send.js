// pages/send/send.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    accountId:'',
  select:false,
    tihuoWay:'请选择区域',
    Input1:'',
    Text1:'',
    pics:[],//图片集合\
    fileID:'',
    value1:'1',
    value2: '', 
    tieGroupList: []
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
   
    var accountid = wx.getStorageSync('accountId');
    this.setData({
      accountId: accountid,    
      tieGroupList: wx.getStorageSync('tieGroupList')
    })
    
  },
  async getmokuai() {
    let result = await request('/bigWork/sector/allName');
    console.log(result)
    this.setData({
      tieGroupList: result.data
    })
    this.getmokuai();
  },
  inputFunction: function (edit) {
    console.log(edit)
  },
  handleInput(event) {
    let type = event.currentTarget.id;// 用ID传值
    //let type = event.currentTarget.dataset.type;
    console.log(event);
    this.setData({
      [type]: event.detail.value
    })
  },
  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {
   
  },
  getselect() {
    
    this.setData({
      select: !this.data.select
    })

  },
  mySelect(e) {

    var name = e.currentTarget.dataset.name

    this.setData({

      tihuoWay: name,

      select: false

    })

  },
  send1(){
    let pics = this.data.pics;
    console.log(pics+"哈哈哈哈");
    console.log(pics[0]);
    console.log(pics[1]);
    console.log(pics[2]);
      //上传图片的名字
    for (var i = 0; i < pics.length; i++) {
      const cloudPath = 'my-image' + Date.now() + pics[i].match(/\.[^.]+?$/)[0] 
      wx.cloud.uploadFile({    //将图片上传到云服务器的云存储中
        cloudPath, //云存储的路径
        filePath: pics[i],  //本地图片路径
        success: res => {
          this.setData({
            fileID: res.fileID
          })
          console.log('[上传文件] 成功：', res)
          console.log('res.fileID',res.fileID);
          app.globalData.fileID = res.fileID
          app.globalData.cloudPath = cloudPath
          app.globalData.imagePath = filePath

        },
        fail: e => {
          console.error('[上传文件] 失败：', e)
          wx.showToast({
            icon: 'none',
            title: '上传失败',
          })
        },
        complete: () => {
          wx.hideLoading()
        }
      })
    }
  },
  send(){
   let value1 = this.data.value1
    if(value1 == 1){
    this.send1()
    this.setData({
      value1: 2
    })
      
    
    }
    
    let { accountId, tihuoWay, Input1, Text1, fileID,value2} = this.data;
    if (value2 ==""){
      this.setData({
        value2:'3'
      })
    return;
    }
    let value = -1;
    if (tihuoWay == "恋爱区"){
      value = 2;
      }
      else if(tihuoWay == "编程区"){
      value = 1
      }

    wx.request({
      url: 'http://localhost:8080/bigWork/topic/add',  //这里''里面填写你的服务器API接口的路径  
      data: {
        accountId: accountId,
        title: Input1,
        topicText: Text1,
        sectorId: value,
        topicPicture: fileID

      },  //这里是可以填写服务器需要的参数  
      method: 'GET', // 声明GET请求  
      // header: {}, // 设置请求的 header，GET请求可以不填  
      success: function (res) {
        wx.showToast({
          title: '发帖成功!',
          
        })
        wx.reLaunch({
          url: '/pages/alltie/alltie',
        })
      },
      fail: function (fail) {
      console.log("发贴失败");
      },
      complete: function (arr) {
        // 这里是请求以后返回的所以信息，请求方法同上，把res改一下就行了  
      }
    })  
  },
  // uploader(e){
  //   var that = this, pics = this.data.pics;
  //   wx.chooseImage({
  //     count:1,
  //     sizeType:['compressed'],
  //     sourceType:['album','camera'],
  //     success: function(res) {
  //       let filePath = res.tempFilePaths[0];
  //       const cloudPath = Math.random()*1000000 +filePath.match(/\.[^.]+?$/)[0];
  //       wx.clound.uploadFile({
  //         cloundPath,
  //         filePath,
  //         success:res =>{
  //           console.log(res)
  
  //         }
  //       })
  //     },
  //   })
  // },
  uploader: function () {
    var that = this, pics = this.data.pics;
    // 选择图片
    wx.chooseImage({
      count: 1, // 最多可以选择的图片张数，默认9
      sizeType: ['original', 'compressed'], // original 原图，compressed 压缩图，默认二者都有
      sourceType: ['album', 'camera'], // album 从相册选图，camera 使用相机，默认二者都有
      success: function (res) {
        
        // 返回选定照片的本地文件路径列表，tempFilePath可以作为img标签的src属性显示图片
        
        var tempFilePaths = res.tempFilePaths;
        // wx.showToast({
        //   title: '正在上传...',
        //   icon: 'loading',
        //   mask: true,
        //   duration: 10000
        // });
        for (var i = 0; i < tempFilePaths.length; i++) {
          pics.push(tempFilePaths[i]);
        }
        console.log(pics);
        that.setData({
          pics: pics
        })
        
      },
    });
  },
  // updata(e){
  //   let pics = this.data.pics;
  //     console.log(pics+"ahahah")
  //       上传图片

  //       const cloudPath = 'my-image' + Date.now() + filePath.match(/\.[^.]+?$/)[0]   //上传图片的名字
  //       for(var i =0;i<pics.length;i++){
  //       wx.cloud.uploadFile({    //将图片上传到云服务器的云存储中
  //         cloudPath, //云存储的路径
  //         filePath:pics[i],  //本地图片路径
  //         success: res => {
  //           console.log('[上传文件] 成功：', res)

  //           app.globalData.fileID = res.fileID
  //           app.globalData.cloudPath = cloudPath
  //           app.globalData.imagePath = filePath

  //           wx.navigateTo({
  //             url: '../storageConsole/storageConsole'
  //           })
  //         },
  //         fail: e => {
  //           console.error('[上传文件] 失败：', e)
  //           wx.showToast({
  //             icon: 'none',
  //             title: '上传失败',
  //           })
  //         },
  //         complete: () => {
  //           wx.hideLoading()
  //         }
  //       })
  //       }

    
  
  // },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  }
})