package services.apiFilter;

import models.Api;
import scala.concurrent.java8.FuturesConvertersImpl;
import services.apiStates.ApiStates;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ApprovedCriteria implements ApiStateCriteria {

    @Override
    public List<Api> meetCriteria(List<Api> apis) {
        List<Api> approvedApis = new ArrayList<>();
        // Loop through the APIs to filer out the approved ones
        Iterator<Api> apiIterator = apis.iterator();
        while(apiIterator.hasNext()) {
            Api api = apiIterator.next();
            if (api.getState() == ApiStates.APPROVED) {
                approvedApis.add(api);
            }
        }

        return approvedApis;
    }
}
