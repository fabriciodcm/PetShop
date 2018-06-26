<%-- 
    Document   : Pets
    Created on : Jun 25, 2018, 11:22:10 PM
    Author     : fa_do
--%>

<%@page import="com.google.gson.Gson"%>
<%@page import="java.util.List"%>
<%
int id = Integer.parseInt(request.getParameter("idDono")) ;
entidades.PetJpaController controller = new entidades.PetJpaController();
List<entidades.Pet> pets = controller.findPetByDonoId(id);


String json = new Gson().toJson(pets );
 response.setContentType("application/json");
%>

<%= json %>