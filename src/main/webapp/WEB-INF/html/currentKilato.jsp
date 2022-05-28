<%@page import="hu.godenyd.servlet.kilatopont.model.Hegyseg"%>
<%@page import="hu.godenyd.servlet.kilatopont.model.Kilatopont"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
Kilatopont kilato = Hegyseg.getHegyseg().getCurrentKilatopont();
%>
<% if (kilato != null) {%>
Jelenlegi kilátó:
Név: <%= kilato.getNev() %>
Magasság: <%= kilato.getMagassag() %>
Környezet: <%= kilato.getKornyezet().name() %>
<% } %>