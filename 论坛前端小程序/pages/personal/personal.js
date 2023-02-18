// pages/personal/personal.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    accountId:'',
    userName:'',
    accountPicture:''

  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var accountid = wx.getStorageSync('accountId');
    var userName = wx.getStorageSync('userName');
    var accountPicture = wx.getStorageSync('accountPicture');
    this.setData({
      accountId: accountid,
       userName: userName,
      accountPicture: accountPicture
    })
    
   
   
  },
  login(){
  wx.showModal({
    title: '提示',
    content: '确认要退出账号吗？',
    success:function(res){
      if(res.confirm){//点击确认
        wx.clearStorage()
        wx.reLaunch({
          url: '/pages/login/login',
        })
      }
    }
  })
  },
  gomytie(){
    wx.navigateTo({
      url: '/pages/mytie/mytie',
    })
    wx.setStorageSync('accountId', accountId);
    wx.reLaunch({
      url: '/pages/mytie/mytie',
    })
  },
   gomytie1(){
     wx.navigateTo({
       url: '/pages/forget/forget',
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