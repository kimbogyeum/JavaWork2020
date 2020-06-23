<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- 작성자 : ${dto.name}<br> --%>
<%-- 글제목 : ${dto.subject}<br> --%>
<%-- 내용 : ${dto.content}<br> --%>

<!-- writeDTO 대문자로 쓰면 안됨 -->
작성자 : ${writeDTO.name}<br>
글제목 : ${writeDTO.subject}<br>
내용 : ${writeDTO.content}<br>