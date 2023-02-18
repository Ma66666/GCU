// pages/mytie/mytie.js
import request from '../../utils/request'
Page({

  /**
   * 页面的初始数据
   */
  data: {
    accountId:'',
    list: ["/images/index/轮播图/店家1.jpg", "/images/index/轮播图/店家2.jpg", "/images/index/轮播图/店家3.jpg"],
    list1: ["gobagui", "goshuitie", "gobanzhu"],
    list2:[]//帖子内容集合
  },

  /**
   * 生命周期函数--监听页面加载
   */
   onLoad: function (options) {
    var accountId = wx.getStorageSync('accountId');
  this.setData({
    accountId:accountId
  })
    console.log(accountId)
    this.getList1(accountId);
  },
getList1(e){
  let ee = e;
 this.getList2(ee)
},

  
 async getList2(e){
  
   console.log(e)
   let videoGroupListData = await request('/bigWork/topic/list', { accountId:e});
    console.log(videoGroupListData+'111')
    this.setData({
      list2: videoGroupListData.data
    })
 
  },
  shanchu(event) {
    this.setData({
      topicId1: event.currentTarget.id
    })
    console.log(event.currentTarget.id)
    wx.showModal({
      title: '提示',
      content: '确认删除该贴吗？',
      success: function (res) {
        if (res.confirm) {
          wx.request({
            url: 'http://localhost:8080/bigWork/topic/delect',  //这里''里面填写你的服务器API接口的路径  
            data: {
              topicId: event.currentTarget.id

            },  //这里是可以填写服务器需要的参数  
            method: 'GET', // 声明GET请求  
            // header: {}, // 设置请求的 header，GET请求可以不填  

          })
          wx.navigateTo({
            url: '/pages/mytie/mytie',
          })
        }
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