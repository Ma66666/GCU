// pages/login/login.js
import request from '../../utils/request'
Page({

  /**
   * 页面的初始数据
   */
  
  data: {
    accountId: '',//账号
    password: '',//密码
    user:'',//用户
    userName:''
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {

  },
  handleInput(event) {
    let type =event.currentTarget.id;// 用ID传值
    //let type = event.currentTarget.dataset.type;
    console.log(event);
    this.setData({
      [type]: event.detail.value
    })
  },
  radiochange(event){
    console.log(event);
    let name = event.detail.value;
    this.setData({
      user:name
    })
    
  },
  forget(){
    wx.navigateTo({
      url: '/pages/forget/forget',
    })
  },
  async login() {

    let { accountId, password,user } = this.data;
    //前端验证手机号验证：1.内容为空 2 手机号格式不对 3手机号格式正确，验证通过

    // if (!phone) {
    //   wx.showToast({
    //     title: '手机号不能为空',
    //     icon: 'none'
    //   })
    //   return;
    // }
    //定义正则表达式
    // let phoneReg = /^1(3|4|5|6|7|8|9)\d{9}$/;
    // if (!phoneReg.test(phone)) {
    //   wx.showToast({
    //     title: '手机号格式错误',
    //     icon: 'none'
    //   })
    //   return;
    // }
    // if (!password) {
    //   wx.showToast({
    //     title: '密码不能为空',
    //     icon: 'none'
    //   })
    //   return;
    // }
    let result = await request('/bigWork/account/login', { accountId, password,isLogin: true });
    console.log(result.data.accountPicture)
    this.setData({
      userName: result.data.accountName
    })
    if (result.data.accountStatus == "0" || result.data.accountStatus == "1") {
      wx.showToast({
        title: '登录成功'
      })
      wx.setStorageSync('accountId', accountId);
      wx.setStorageSync('userName', result.data.accountName);
      wx.setStorageSync('accountStatus', result.data.accountStatus);
      wx.setStorageSync('accountPicture', result.data.accountPicture);
      console.log(result.data.accountPicture)
      wx.reLaunch({
        url: '/pages/personal/personal',
      })

    } else if (user == "管理员" && result.data.accountStatus == "2"){
      wx.showToast({
        title: '登录成功'
      })
      wx.setStorageSync('accountId', accountId);
      wx.setStorageSync('userName', result.data.accountName);
      wx.setStorageSync('accountStatus', result.data.accountStatus);
      wx.setStorageSync('accountPicture', result.data.accountPicture);
      wx.reLaunch({
        url: '/pages/personal/personal',
      })
    } else if (result.data.accountStatus == "-1"){
      wx.showToast({
        title: '登录失败，你的账号已被封停',
        icon: 'none'
      })
    }
    
    else{
      wx.showToast({
        title: '登录失败,请重新检查手机号码是否正确，或者重新输入密码',
        icon:'none'
      })
    }
    


  },
   youke(){
     
     this.setData({
       user:'游客'
     })
     let { user } = this.data;
     wx.setStorageSync('user', user);
     wx.reLaunch({
       url: '/pages/index/index',
     })
   },
  register(){
    wx.reLaunch({
      url: '/pages/register/register',
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