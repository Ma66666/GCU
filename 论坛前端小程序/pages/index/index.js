// pages/index/index.js
import request from '../../utils/request'
Page({

  /**
   * 页面的初始数据
   */
  data: {
    list: ["/images/index/轮播图/吧规.png", "/images/index/轮播图/水贴.png", "/images/index/轮播图/版主.png"],
    list1: ["gobagui", "goshuitie", "gobanzhu"],
    accountStatus:'',
    user:'',
    list2:[],//管理员获取没被封号用户集合
    accountId:'',
    list3:[],//管理员获取被封号的账号信息
    list4:[],//版主类型,
    tihuoWay: '请选择区域',
    tieGroupList: [],
    name:''//板块名字
  },
  gobagui(){
    wx.navigateTo({
      url: '/pages/bagui/bagui',
    })
  },
  goshuitie() {
    wx.navigateTo({
      url: '/pages/bshuitie/bshuitie',
    })
  },
  gobanzhu() {
    wx.navigateTo({
      url: '/pages/banzhu/banzhu',
    })
  },
  goalldianjia() {
    wx.navigateTo({
      url: '/pages/alldianjia/alldianjia',
    })
  },
  handleInput(event) {
    let type = event// 用ID传值
    //let type = event.currentTarget.dataset.type;
    console.log(event);
    this.setData({
      accountId:type
    })
    wx.showModal({
      title: '提示',
      content: '确认封改账号吗？',
      success: function (res) {
        if (res.confirm) {
        wx.request({
          url: 'http://localhost:8080/bigWork/account/delete',  //这里''里面填写你的服务器API接口的路径  
          data: {
            accountId:type,
   
          },  //这里是可以填写服务器需要的参数  
          method: 'GET', // 声明GET请求  
          // header: {}, // 设置请求的 header，GET请求可以不填  
          
        })
        wx.reLaunch({
          url: '/pages/index/index',
        })
        }
      }
    })
  
  },

  handleInput5(event) {
    let type = event.currentTarget.id;// 用ID传值
    //let type = event.currentTarget.dataset.type;
    console.log(event);
    this.setData({
      name: event.detail.value
    })
  },


  handleInput1(event) { //解封
    let type = event;// 用ID传值
    //let type = event.currentTarget.dataset.type;
    console.log(event);
    this.setData({
      accountId: type
    })
    wx.showModal({
      title: '提示',
      content: '确认解封该账号吗？',
      success: function (res) {
        if (res.confirm) {
          wx.request({
            url: 'http://localhost:8080/bigWork/account/resume',  //这里''里面填写你的服务器API接口的路径  
            data: {
              accountId: type,

            },  //这里是可以填写服务器需要的参数  
            method: 'GET', // 声明GET请求  
            // header: {}, // 设置请求的 header，GET请求可以不填  
            success: (res) => {
              wx.showToast({
                title: '解封成功'
              })
            },
            fail: (res) => {
              wx.showToast({
                title: '解封失败，请检查该账户是否被封禁',
                icon: 'none'
              })
            }
          })
          wx.reLaunch({
            url: '/pages/index/index',
          })
        }
      }
    })

  },
  handleInput2(event) { //设置为恋爱去版主版主
    let type = event// 用ID传值
    //let type = event.currentTarget.dataset.type;
    console.log(event);
    this.setData({
      accountId: type
    })
    wx.showModal({
      title: '提示',
      content: '确认设置该账号为恋爱区版主吗？',
      success: function (res) {
        if (res.confirm) {
          wx.request({
            url: 'http://localhost:8080/bigWork/account/up',  //这里''里面填写你的服务器API接口的路径  
            data: {
              accountId: type,
              sectorName:'恋爱区'

            },  //这里是可以填写服务器需要的参数  
            method: 'GET', // 声明GET请求  
            // header: {}, // 设置请求的 header，GET请求可以不填  
        success :(res) =>{
          wx.showToast({
            title: '设置成功'
          })
        },
        fail:(res) =>{
          wx.showToast({
            title: '设置失败',
            icon: 'none'
          })
        }
          })
          wx.reLaunch({
            url: '/pages/index/index',
          })
        }
      }
    })

  },
  handleInput3(event) { //设置为恋爱去版主版主
    let type = event;// 用ID传值
    //let type = event.currentTarget.dataset.type;
    console.log(event);
    this.setData({
      accountId: type
    })
    wx.showModal({
      title: '提示',
      content: '确认设置该账号为编程区版主吗？',
      success: function (res) {
        if (res.confirm) {
          wx.request({
            url: 'http://localhost:8080/bigWork/account/up',  //这里''里面填写你的服务器API接口的路径  
            data: {
              accountId: type,
              sectorName: '编程区'

            },  //这里是可以填写服务器需要的参数  
            method: 'GET', // 声明GET请求  
            // header: {}, // 设置请求的 header，GET请求可以不填  

          })
          wx.reLaunch({
            url: '/pages/index/index',
          })
        }
      }
    })

  },
 async handleInput4(event) {  
   let type = event;// 用ID传值
   //let type = event.currentTarget.dataset.type;
   console.log(event);
   this.setData({
     accountId: type
   })
   wx.showModal({
     title: '提示',
     content: '确认解除该账号的版主职位吗？',
     success: function (res) {
       if (res.confirm) {
         wx.request({
           url: 'http://localhost:8080/bigWork/account/down',  //这里''里面填写你的服务器API接口的路径  
           data: {
             accountId: type,

           },  //这里是可以填写服务器需要的参数  
           method: 'GET', // 声明GET请求  
           // header: {}, // 设置请求的 header，GET请求可以不填  

         })
         wx.reLaunch({
           url: '/pages/index/index',
         })
       }
     }
   })
    
  },
  queren1(){
    let name = this.data.name;
    if(name ==""){ 
        wx.showToast({
          title: '创建失败，板块名字不能为空',
          icon:'none'
        })
  return
     
    }
    wx.showModal({
      title: '提示',
      content: '确认创建该板块吗？',
      success: function (res) {
        if (res.confirm) {
          wx.request({
            url: 'http://localhost:8080/bigWork/sector/establish',  //这里''里面填写你的服务器API接口的路径  
            data: {
              sectorName: name,

            },  //这里是可以填写服务器需要的参数  
            method: 'GET', // 声明GET请求  
            // header: {}, // 设置请求的 header，GET请求可以不填  

          })
          wx.reLaunch({
            url: '/pages/index/index',
          })
        }
      }
    })
  },
  queren1() {
    let name = this.data.name;
    if (name == "") {
      wx.showToast({
        title: '删除失败，板块名字不能为空',
        icon: 'none'
      })
      return

    }
    wx.showModal({
      title: '提示',
      content: '确认创建该板块吗？',
      success: function (res) {
        if (res.confirm) {
          wx.request({
            url: 'http://localhost:8080/bigWork/sector/establish',  //这里''里面填写你的服务器API接口的路径  
            data: {
              sectorName: name,

            },  //这里是可以填写服务器需要的参数  
            method: 'GET', // 声明GET请求  
            // header: {}, // 设置请求的 header，GET请求可以不填  

          })
          wx.reLaunch({
            url: '/pages/index/index',
          })
        }
      }
    })
  },
  queren2() {
    let name = this.data.name;
    if (name == "") {
      wx.showToast({
        title: '删除失败，板块名字不能为空',
        icon: 'none'
      })
      return

    }
    wx.showModal({
      title: '提示',
      content: '确认删除该板块吗？',
      success: function (res) {
        if (res.confirm) {
          wx.request({
            url: 'http://localhost:8080/bigWork/sector/delect',  //这里''里面填写你的服务器API接口的路径  
            data: {
              sectorName: name,

            },  //这里是可以填写服务器需要的参数  
            method: 'GET', // 声明GET请求  
            // header: {}, // 设置请求的 header，GET请求可以不填  

          })
          wx.reLaunch({
            url: '/pages/index/index',
          })
        }
      }
    })
  },
  // async handleInput5(event) {
  //   let type = event.currentTarget.id;// 用ID传值
  //   //let type = event.currentTarget.dataset.type;
  //   console.log(type);
  //   this.setData({
  //     // name: type
  //   })

  // },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
  
   this.setData({
     index:0,
     accountStatus: wx.getStorageSync('accountStatus'),
     user:wx.getStorageSync('user')
   }),
   this.getlist2();

   this.getmokuai();
  },
  async getmokuai() {
    let result = await request('/bigWork/sector/allName');
    console.log(result)
    this.setData({
      tieGroupList: result.data
    })
  },

  async getlist2(){
    let result1 = await request('/bigWork/sector/allList');
    let result = await request('/bigWork/account/list');
    this.setData({
      list2: result.data,
      list4:result1.data
    })
    console.log(result)
  },
  getselect() {

    this.setData({

      select: !this.data.select

    })

  }, mySelect(e) {

    var name = e.currentTarget.dataset.name

    this.setData({

      tihuoWay: name,

      select: false

    })

  },
  // 复选框获取ID
  checkboxChange(e){
    console.log(e.detail.value)
    this.setData({
      accountId:e.detail.value
    })
  },
  
  queren(){
   let accountId = this.data.accountId
   let tihuoWay = this.data.tihuoWay
  if(tihuoWay == "封号"){
    this.handleInput(accountId)
  }
  else if (tihuoWay == "解封"){
    this.handleInput1(accountId)

  }
  else if (tihuoWay == "恋爱区") {
    this.handleInput2(accountId)

  }
  else if (tihuoWay == "编程区") {
    this.handleInput3(accountId)

  }
  else if (tihuoWay == "解除") {
    this.handleInput4(accountId)

  }
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