// @GENERATOR:play-routes-compiler
<<<<<<< HEAD
// @SOURCE:/Users/JeromeKimbrough/Documents/Scolaire/CMU/Classes/2 - 18653 Software Design and Architecture/Project/backend/conf/routes
// @DATE:Fri Mar 30 12:19:26 PDT 2018
=======
// @SOURCE:/Users/tomzhou94/Documents/CMU/SAD/18653-Spring-2018-Team-3/backend/conf/routes
// @DATE:Thu Mar 29 17:00:19 PDT 2018
>>>>>>> Add backend functionalities for submitting and searching a Mashup

package controllers;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.ReverseMashupController MashupController = new controllers.ReverseMashupController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseLoginController LoginController = new controllers.ReverseLoginController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseAssets Assets = new controllers.ReverseAssets(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseUserController UserController = new controllers.ReverseUserController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseApiController ApiController = new controllers.ReverseApiController(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.javascript.ReverseMashupController MashupController = new controllers.javascript.ReverseMashupController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseLoginController LoginController = new controllers.javascript.ReverseLoginController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseAssets Assets = new controllers.javascript.ReverseAssets(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseUserController UserController = new controllers.javascript.ReverseUserController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseApiController ApiController = new controllers.javascript.ReverseApiController(RoutesPrefix.byNamePrefix());
  }

}
