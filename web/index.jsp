<%-- 
    Document   : index
    Created on : May 6, 2018, 4:01:08 PM
    Author     : fa_do
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <% 
        entidades.Dono dono = new entidades.Dono();
        dono.setEmail("fabricio.docema@gmail.com");
        dono.setNome("Fabricio Docema");
        dono.setTelefone("3533-3333");
        entidades.DonoJpaController controller = new entidades.DonoJpaController();
        controller.create(dono);
        
        dono = controller.findDono(1);
        
        entidades.Pet pet = new entidades.Pet();
        pet.setCaracteristicas("Pelo braco e vermelho, agitada");
        pet.setEspecie("Cachorro");
        pet.setIdDono(dono.getIdDono());
        pet.setNome("Doris");
        pet.setRaca("Red Heeler");
        entidades.PetJpaController controller2 = new entidades.PetJpaController();
        controller2.create(pet);
        %>
    </body>
</html>
