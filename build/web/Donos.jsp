<%-- 
    Document   : Donos
    Created on : Jun 25, 2018, 7:11:53 PM
    Author     : fa_do
--%>



<%@page import="com.google.gson.Gson"%>
<%@page import="java.util.List"%>
<%
//int id = Integer.parseInt(request.getParameter("id")) ;
entidades.DonoJpaController controller = new entidades.DonoJpaController();
List<entidades.Dono> donos = controller.findDonoEntities();


String json = new Gson().toJson(donos );
 response.setContentType("application/json");
%>

<%= json %>