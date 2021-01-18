import request from '@/utils/request'

// 获取用户列表
export function getUserInfo(data) {
    return request({
      url: '/getUserInfo',
      method: 'get',
      params:data

    })
  }
//获取用户信息
export function getUser(userId) {
  return request({
    url: '/getUser?userId='+userId,
    method: 'get'
  })
}




//修改用户信息
export function updateUserInfo(data) {
  console.log("修改值"+JSON.stringify(data));
  return request({
    url: '/updateUserInfo',
    method: 'post',
    data: data
  })
}
//新增用户信息
export function addUser(userId) {
  const data = {
    userId,
    password
  }
  return request({
    url: '/addUser',
    method: 'POST',
    data: data
  })
}
//修改用户状态
export function changeUserStatus(userId,status){
  const data ={
    userId,
    status
  }
  return request({
    url: '/changeUserStatus',
    method: 'POST',
    data: data
  })
}