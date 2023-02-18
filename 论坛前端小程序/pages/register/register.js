// pages/register/register.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
  accountId:'',
  password:'',
  iphoneNumber:'',
  accountName:'',
    pics:[],
    value:'1',
    fileID: '',
    value1:'1',//判断
    value2:'',//判断
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {

  },
  handleInput(event) {
    let type = event.currentTarget.id;// 用ID传值
    //let type = event.currentTarget.dataset.type;
    console.log(event);
    this.setData({
      [type]: event.detail.value
    })
  },
  register(){
    let value1 = this.data.value1
    if (value1 == 1) {
      this.send1()
      this.setData({
        value1: 2
      })
    }
    let { accountId, password, iphoneNumber, accountName, fileID,value2 } = this.data;
    if (value2 == "") {
      this.setData({
        value2: '3'
      })
      return;
    }
    if (fileID==""){
      wx.showToast({
        title: '头像不能为空!',
        icon: 'none'
      })
      this.setData({
        value2:"",
        value1:1
      })
      return
    }
   
    wx.request({
      url: 'http://localhost:8080/bigWork/account/add',  //这里''里面填写你的服务器API接口的路径  
      data: { accountId:accountId, 
      password:password,
        iphoneNumber:iphoneNumber,
        accountName:accountName,
        accountPicture:fileID},  //这里是可以填写服务器需要的参数  
      method: 'GET', // 声明GET请求  
      // header: {}, // 设置请求的 header，GET请求可以不填  
      success: function (res) {
        if (res.data.err_msg == "帐号已经存在~"){
          console.log(res.data.err_msg);
          wx.showToast({
            title: '账号已存在!',
            icon: 'none'
          })
      
        }
        wx.reLaunch({
          url: '/pages/login/login',
        })
      },
      fail: function (fail) {

      },
      complete: function (arr) {
        // 这里是请求以后返回的所以信息，请求方法同上，把res改一下就行了  
      }
    })  
  },
  uploader: function () {
    var that = this, pics = this.data.pics;
    this.setData({
      value: 2
    })
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
  send1() {
    let pics = this.data.pics;
    console.log(pics + "哈哈哈哈");
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
          console.log('res.fileID', res.fileID);
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
  uploader1(){
    this.setData({
      pics:[],
      value:'1'
    })
  },
  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },

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