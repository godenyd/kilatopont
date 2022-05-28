<%@page import="hu.godenyd.servlet.kilatopont.util.WebKeys"%>
<%@page import="hu.godenyd.servlet.kilatopont.util.ActionKeys"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<form name="addKilatopontForm" method="post" action="kilato">
    <input type="hidden" name="<%= WebKeys.ACTION %>" value="<%= ActionKeys.SAVE_KILATO %>" />
    <span>Név: </span><input type="text" name="<%= WebKeys.NEV %>"/><br />
    <span>Magasság: </span><input type="text" name="<%= WebKeys.MAGASSAG %>"/><br />
    <span>Környezet: </span>
    <select name="<%= WebKeys.KORNYEZET %>">
        <option value="NOVENYES">Növényes</option>
        <option value="SZIKLAS">Sziklás</option>
    </select>
    <input type="submit" value="Mentés"/>
</form>