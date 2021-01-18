package com.first.start.project.system.model;

public class QueryBody {
/**
 * 当前页
 */
	Long currentPage;
	/**
	 * 每页显示数量
	 */
	Long pageSize;
	/**
	 * 用户id
	 */
	Long userId;
	/**
	 * 用户名
	 */
	String userName;
	/**
	 * 手机号
	 */
	String phoneNumber;
	public Long getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(Long currentPage) {
		this.currentPage = currentPage;
	}
	public Long getPageSize() {
		return pageSize;
	}
	public void setPageSize(Long pageSize) {
		this.pageSize = pageSize;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

}
