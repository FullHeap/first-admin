import request from '@/utils/request'

// 获取用户列表
export function getUserInfo(data) {
    return request({
      url: '/getUserInfo',
      method: 'get',
      params:data

    })
  }