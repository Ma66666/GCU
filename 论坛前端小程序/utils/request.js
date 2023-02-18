import config from './config'
// 1.功能点明确
// 2.将动态的数据抽成形参，由使用者根据自身情况动态的传入实参
// 3.函数内部应该保留固定代码
// 4.一个良好的功能函数应该设置形参默认值

// 2.封装功能组件
// 1.功能点明确
// 2.组件内部保留静态的代码
// 3.将动态的数据抽成props参数，由使用者根据自身的情况以标签属性的形式动态传入props数据
// 4.一个良好的组件应该设置组件的必要性以及数据类型
// props: {
//   msg: {
//     require: true,
//          default: 默认值,
//       type：
//   }
// }

export default (url, data = {}, method = 'GET') => {
return new Promise((resolve,reject) => {
  wx.request({
    url: config.host + url,
    data,
    method,
    header:{
      cookie:wx.getStorageSync('cookies')?wx.getStorageSync('cookies').find(item =>item.indexOf('MUSIC_U')!==-1):''
    },
    success: (res) => {
      console.log('请求成功 ', res);
      if(data.isLogin){
        //登录请求，将用户cookie存入本地
        wx.setStorage({
          key: 'cookies',
          data: res.cookies,
        })
      }
      resolve(res.data);// 修改promise为成功状态resolved
    },
    fail: (err) => {
      console.log('请求失败 ', err);
      reject(err);//reject修改promise的状态为失败状态 rejected
    }
  })
})
}