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
        entidades.Dono dono2 = new entidades.Dono();
        dono2.setEmail("leandro.rui@gmail.com");
        dono2.setNome("Leandro Rui");
        dono2.setTelefone("3524-2424");
        
        controller.create(dono);
         controller.create(dono2);
        
        dono = controller.findDono(1);
        
        entidades.Pet pet = new entidades.Pet();
        pet.setCaracteristicas("Pelo branco e vermelho, agitada");
        pet.setEspecie("Cachorro");
        pet.setIdDono(dono.getIdDono());
        pet.setNome("Doris");
        pet.setRaca("Red Heeler");
        entidades.Pet pet2 = new entidades.Pet();
        pet2.setCaracteristicas("Pelo branco e preto, docil e calma");
        pet2.setEspecie("Gato");
        pet2.setIdDono(dono.getIdDono());
        pet2.setNome("Brisola");
        pet2.setRaca("Indefinido");
        entidades.Pet pet3 = new entidades.Pet();
        pet3.setCaracteristicas("Gato preto e musculoso");
        pet3.setEspecie("Gato");
        pet3.setIdDono(dono2.getIdDono());
        pet3.setNome("Tissao");
        pet3.setRaca("Gato Pardo");
        entidades.PetJpaController controller2 = new entidades.PetJpaController();
        controller2.create(pet);
        controller2.create(pet2);
        controller2.create(pet3);
        %>
    </body>
</html>
