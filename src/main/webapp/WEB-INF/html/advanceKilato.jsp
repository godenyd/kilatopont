<%@page import="hu.godenyd.servlet.kilatopont.util.WebKeys"%>
<%@page import="hu.godenyd.servlet.kilatopont.util.ActionKeys"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<form name="advanceKilatoForm" method="post" action="kilato">
    <input type="hidden" name="<%= WebKeys.ACTION %>" value="<%= ActionKeys.ADVANCE_KILATO %>" />
    <input type="submit" value="Következő kilátó"/>
</form>