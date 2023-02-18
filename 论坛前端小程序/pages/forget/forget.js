// pages/forget/forget.js
Page({

  /**
   * 页面的初始数据
   */
  data: {
    accountId: '',
    password: '',
    iphoneNumber: '',
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
  forget() {
    let { accountId, password, iphoneNumber} = this.data;
    wx.request({
      url: 'http://localhost:8080/bigWork/account/update',  //这里''里面填写你的服务器API接口的路径  
      data: {
        accountId: accountId,
        password: password,
        iphoneNumber: iphoneNumber,
        
      },  //这里是可以填写服务器需要的参数  
      method: 'GET', // 声明GET请求  
      // header: {}, // 设置请求的 header，GET请求可以不填  
      success: function (res) {
        console.log(res);
        if (res.data.err_msg == "帐号或者手机号码错误~"){
          wx.showToast({
            title: '修改密码失败',
            icon:'none'
          })
          return;
        }
        wx.showToast({
          title: '修改密码成功'
        })
        wx.navigateTo({
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