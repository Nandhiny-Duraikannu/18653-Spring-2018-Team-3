// @GENERATOR:play-routes-compiler
<<<<<<< HEAD
// @SOURCE:/Users/JeromeKimbrough/Documents/Scolaire/CMU/Classes/2 - 18653 Software Design and Architecture/Project/frontend/conf/routes
// @DATE:Fri Mar 30 13:00:19 PDT 2018
=======
// @SOURCE:/Users/tomzhou94/Documents/CMU/SAD/18653-Spring-2018-Team-3/frontend/conf/routes
<<<<<<< HEAD
// @DATE:Thu Mar 29 12:45:14 PDT 2018
>>>>>>> Add backend functionalities for submitting and searching a Mashup
=======
// @DATE:Thu Mar 29 23:54:03 PDT 2018
>>>>>>> Add frontend for submitting and searching Mashups

package controllers;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.ReverseMashupController MashupController = new controllers.ReverseMashupController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseLoginController LoginController = new controllers.ReverseLoginController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseAssets Assets = new controllers.ReverseAssets(RoutesPrefix.byNamePrefix());
  public static final controllers.ReverseSubmitApiController SubmitApiController = new controllers.ReverseSubmitApiController(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.javascript.ReverseMashupController MashupController = new controllers.javascript.ReverseMashupController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseLoginController LoginController = new controllers.javascript.ReverseLoginController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseAssets Assets = new controllers.javascript.ReverseAssets(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReverseSubmitApiController SubmitApiController = new controllers.javascript.ReverseSubmitApiController(RoutesPrefix.byNamePrefix());
  }

}
