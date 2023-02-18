// pages/search/search.js
import request from '../../utils/request'
Page({

  /**
   * 页面的初始数据
   */
  data: {
   list:[],
   searchId:'',
   list2:[]
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
   this.getList();
  },
  handleInput(event) {
    let type = event.currentTarget.id;// 用ID传值
    //let type = event.currentTarget.dataset.type;
    console.log(event);
    this.setData({
      [type]: event.detail.value
    })
  },
  async getList() {
    let result = await request('/bigWork/topic/allList');
    console.log(result)
    this.setData({
      list: result.data,
      
    })
  },
 async search(){
   let {searchId} = this.data;
   let se = await request('/bigWork/topic/check', {topicName: searchId });
  
   this.setData({
     list2: se.data
   })
 },
  gotie(e) {
    let nav = e.currentTarget.id;
    //路由跳转穿参数
    console.log(nav)
    wx.setStorageSync('topicId', nav);
    wx.navigateTo({
      url: '/pages/tie/tie',
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