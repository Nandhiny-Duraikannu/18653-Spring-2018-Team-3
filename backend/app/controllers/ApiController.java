package controllers;

import DAO.*;
import com.fasterxml.jackson.databind.JsonNode;
import models.*;
import play.data.DynamicForm;
import play.data.FormFactory;
import play.libs.Json;
import play.mvc.*;
import services.ApiFactory;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class ApiController extends Controller {
    private final FormFactory formFactory;
    private MashupDAO mashupDAO = new MashupDAO();
    private ApiDAO apiDAO = new ApiDAO();
    private FollowerDAO followerDAO = new FollowerDAO();
    private UserDAO userDAO = new UserDAO();
    private ApiFactory apiFactory = new ApiFactory();


    @Inject
    public ApiController(FormFactory formFactory) {
        this.formFactory = formFactory;
    }

    @BodyParser.Of(BodyParser.Json.class)
    public Result submitApi() {
        JsonNode apiJson = request().body().asJson();
        String userId = apiJson.findPath("user_id").textValue();
        String apiType = apiJson.findPath("type").textValue();
        String name = apiJson.findPath("name").textValue();
        String homepage = apiJson.findPath("homepage").textValue();
        String endpoint = apiJson.findPath("endpoint").textValue();
        String version = apiJson.findPath("version").textValue();
        String scope = apiJson.findPath("scope").textValue();
        String description = apiJson.findPath("description").textValue();
        String email = apiJson.findPath("email").textValue();

        JsonNode apiIdsNode = apiJson.findPath("apiIds");

        List<Integer> apiIds = new ArrayList<>();
        for (JsonNode n: apiIdsNode) {
            apiIds.add(Integer.valueOf(n.textValue()));
        }

        User user = userDAO.getUserByUserId(Integer.valueOf(userId));
        Api api = apiFactory.createApi(apiType, name, homepage, endpoint, version, scope, description, email, apiIds);
        user.addApi(api);
        user.save();
        return ok(api.toJson());
    }

    @BodyParser.Of(BodyParser.Json.class)
    public Result followApi() {
        JsonNode apiJson = request().body().asJson();
        String userId = apiJson.findPath("user_id").textValue();
        String apiID = apiJson.findPath("api_id").textValue();

        Api submitter = apiDAO.getById(Integer.valueOf(apiID));
        System.out.println("api value for user:"+submitter.toJson());
        Follower follower = apiFactory.followApi(Long.parseLong(userId), Long.parseLong(apiID), Long.parseLong(userId));
        
        return ok(follower.toJson());
    }

    public Result getAllApis () {
        List<JsonNode> apis = new ArrayList<>();
        for (Api api: apiDAO.getAll()) {
            apis.add(api.toJson());
        }
        return ok(Json.toJson(apis));
    }

    public Result getAllFollowers ()
    {
        DynamicForm form = formFactory.form().bindFromRequest();
        String userId = form.get("userId");
        System.out.println("userId test in getall followers"+userId);
        List<Api> apis = apiDAO.searchAPIs(userId);
       
        List<JsonNode> followers = new ArrayList<>();
        for (Follower follower: followerDAO.getAll())
        {
            System.out.println("insides followers");
            for(Api api : apis)
            {
                System.out.println("insides apis");
                System.out.println("b4 if"+api.id + follower.api_id);
                    if(((api.id).toString()).equals((follower.api_id).toString()))
                    {
                       // ObjectNode result = super.toJson().put("status", "Yes");
                        System.out.println("inside if");
                       followers.add(follower.toJson());
                    }
            }
        }
        return ok(Json.toJson(followers));
    }

    public Result searchApi ()
    {
        DynamicForm form = formFactory.form().bindFromRequest();
        String searchParam = form.get("searchParam");
        String userId = form.get("userId");
        String type = form.get("type");


        List<Integer> followers = new ArrayList<>();
        for (Follower follower: followerDAO.getAll())
        {
            if(((follower.follower_id).toString()).equals(userId))
             followers.add(follower.api_id.intValue());
        }

        System.out.println("type followers ID"+ followers);

        if (type.equals("api"))
        {
            List<Api> apis = apiDAO.searchAPIs(searchParam,type);

            List<JsonNode> apisJson = new ArrayList<>();
            for (Api api : apis)
            {
                System.out.println("in api"+ api.toJson());
                if(!followers.isEmpty())
                {
                    System.out.println("inside followers" );
                    //  if(((api.id).toString()).equals(i.toString()))
                    if ((Long.toString(api.id)).equals(Integer.toString(followers.get(0))))
                    {
                        System.out.println("in if");
                        // ObjectNode result = super.toJson().put("status", "Yes");
                        apisJson.add(api.toJson().put("status", "YES"));
                        //  apisJson.add(api.toJson());
                        // ((ObjectNode)jsonNode).put("value", "NO");

                    }
                    else
                    {
                        System.out.println("else");
                        // ObjectNode result = super.toJson().put("status", "No");
                        apisJson.add(api.toJson().put("status","NO"));
                        // apisJson.add(api.toJson());

                    }
                }
                else
                {
                    System.out.println("else");
                // ObjectNode result = super.toJson().put("status", "No");
                    apisJson.add(api.toJson().put("status","NO"));
                   // apisJson.add(api.toJson());
                }
            }
            System.out.println(Json.toJson(apisJson));
            return ok(Json.toJson(apisJson));
        }
        else {
            System.out.println("in mashup search");
            List<Mashup> mashups = mashupDAO.searchMashups(searchParam,type);

            List<JsonNode> mashupsJson = new ArrayList<>();
            for (Mashup mashup : mashups)
            {
                System.out.println("in mashup"+ mashup.toJson());
                if(!followers.isEmpty())
                {
                    System.out.println("inside followers" +mashup.id +" "+followers.get(1));
                    //  if(((api.id).toString()).equals(i.toString()))
                    if ((Long.toString(mashup.id)).equals(Integer.toString(followers.get(1))))
                    {
                        System.out.println("in if");
                        // ObjectNode result = super.toJson().put("status", "Yes");
                        mashupsJson.add(mashup.toJson().put("status", "YES"));
                        //  apisJson.add(api.toJson());
                        // ((ObjectNode)jsonNode).put("value", "NO");

                    }
                    else
                    {
                        System.out.println("else 1");
                        // ObjectNode result = super.toJson().put("status", "No");
                            mashupsJson.add(mashup.toJson().put("status","NO"));
                            // apisJson.add(api.toJson());

                        }
                    }
                    else
                    {
                        System.out.println("else 2");
                        // ObjectNode result = super.toJson().put("status", "No");
                        mashupsJson.add(mashup.toJson().put("status","NO"));
                        // apisJson.add(api.toJson());
                    }

                }
                return ok(Json.toJson(mashupsJson));
            }

    }

    public Result getApiById (int id) {
        Api api = apiDAO.getApiById(id);

        String apiCommentsJson = apiDAO.getCommentsForApi(id);
        String result = api.toJsonWithComments(apiCommentsJson);
        return ok(result);
    }
}
