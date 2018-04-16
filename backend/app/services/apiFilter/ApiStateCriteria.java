package services.apiFilter;

import models.Api;

import java.util.List;

public interface ApiStateCriteria {

    List<Api> meetCriteria(List<Api> apis);

}
