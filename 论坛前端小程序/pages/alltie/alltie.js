// pages/alltie/alltie.js
import request from '../../utils/request'
Page({

  /**
   * 页面的初始数据
   */
  data: {
    tieGroupList:[],
    list:[],//所有帖子的集合
    navId: '',//sectorName导航区ID
    topicId:[],
    accountStatus: '',
    topicId1:[],//删帖子的ID
    accountId:'',
    list2:[],//版主的信息
   sectorName:''
  },

  /**
   * 生命周期函数--监听页面加载
   */
   onLoad: function (options) {
    this.getList();//调用获取所有帖子的方法
   //调用获区版主能删除帖子的方法kn 
    this.setData({
      navId:0,
      accountStatus: wx.getStorageSync('accountStatus'),
      accountId: wx.getStorageSync('accountId'),
    })
     this.getbanzhuList();
     this.getmokuai();
  },

   async getmokuai(){
     let result = await request('/bigWork/sector/allName');
    console.log(result)
    this.setData({
      tieGroupList:result.data
    })
  },
 shanchu(event){
   this.setData({
     topicId1:event.currentTarget.id
   })
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
         wx.reLaunch({
           url: '/pages/alltie/alltie',
         })
       }
     }
   })
 },

  changeNav(event) {
    let navId = event.currentTarget.id; //通过ID向event 传参的时候都是String
    this.setData({
      navId: navId*1
    })
    console.log(navId)
  },
  gosend(){
    let tieGroupList = this.data.tieGroupList;
    wx.setStorageSync('tieGroupList', tieGroupList);
    wx.reLaunch({
      url: '/pages/send/send',
    })
  },
  async getList(){
    let result = await request('/bigWork/topic/allList');
    console.log(result)
    this.setData({
      list: result.data,
      topicId:result.data.topicId
    })
    
  },

   getTopicId(e){
   let nav = e.currentTarget.id;
   //路由跳转穿参数
   console.log(nav)
     wx.setStorageSync('topicId', nav);
   wx.navigateTo({
     url: '/pages/tie/tie',
   })
  },
  gosearch(){
    wx.navigateTo({
      url: '/pages/search/search',
    })
  },
 async getbanzhuList(){
   let accountId = this.data.accountId
   let accountStatus = this.data.accountStatus
   if (accountStatus == 1 ){
   let result = await request('/bigWork/sector/list', { accountId });
   this.setData({
     list2:result.data
   })
    let list = this.data.list2
    this.setData({
      sectorName: list[0].sectorName

    })
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