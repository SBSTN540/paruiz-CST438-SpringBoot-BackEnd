package edu.csumb.Webstore.controller;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.ApiOperation;
import edu.csumb.Webstore.model.User;
import edu.csumb.Webstore.service.UserService;
import javax.validation.Valid;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@RestController
public class UserController
{

    //This is autowiring(Telling spring to just connect to the dang service automatically) for us.
    @Autowired
    UserService userService;

    //REQUESTMAPPING
    //We are setting a request mapping with request type GET. You can change these to POST or anything else you want!
    //The value is the location of the api. So this would be HEROKU/products/example

    //APIOPERATION
    //This is comments that will be displayed in swagger. Remember to do this or you will lose points!

    //EXAMPLE()
    //We are returning an Iterable, which means a List! Use Iterable<Datatype> when you want to return many.
    //For example Iterable<Product>

    @RequestMapping(method = RequestMethod.POST, value = "/user/add")
    public Boolean createUser(@Valid @RequestBody User user)
    {
        return userService.createUser(user);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/user/login/{email}/{password}")
    public Boolean userLogin(@PathVariable("email") String email, @PathVariable("password") String password)
    {
        return userService.userLogin(email, password);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/user/getAll")
    public List<User> getAll()
    {
        return userService.getAll();
    }

    //NETWORKING QUICK REFERENCE
    //IF @RequestMapping(method = RequestMethod.GET, value = "/example/{var}")
    //Then you should use @RequestParam to get the variable, like so
    // public returnType getVar(@RequestParam DataType var)

    //IF  @RequestMapping(method = RequestMethod.POST, value = "/example")
    //Then you should use @RequestBody to get the variable, like so.
    //public returnType foo(@RequestBody dataType var)

    //Put and Delete will use either. They can also be compiled.
    // So IF @RequestMapping(value = "/{pathVar}", method = RequestMethod.PUT)
    //public void foo(@RequestParam dataType pathVar, @RequestBody dataType postVar)


}
