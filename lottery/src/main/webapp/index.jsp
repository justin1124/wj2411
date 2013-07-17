<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Strict//EN" "http://www.w3.org/TR/html4/strict.dtd">
<%response.sendRedirect("http://" + request.getServerName() + ":" + request.getServerPort()+request.getContextPath()+"/index.html"); %>