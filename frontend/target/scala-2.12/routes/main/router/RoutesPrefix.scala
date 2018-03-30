// @GENERATOR:play-routes-compiler
<<<<<<< HEAD
// @SOURCE:/Users/JeromeKimbrough/Documents/Scolaire/CMU/Classes/2 - 18653 Software Design and Architecture/Project/frontend/conf/routes
// @DATE:Fri Mar 30 13:00:19 PDT 2018
=======
// @SOURCE:/Users/tomzhou94/Documents/CMU/SAD/18653-Spring-2018-Team-3/frontend/conf/routes
// @DATE:Thu Mar 29 12:45:14 PDT 2018
>>>>>>> Add backend functionalities for submitting and searching a Mashup


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
