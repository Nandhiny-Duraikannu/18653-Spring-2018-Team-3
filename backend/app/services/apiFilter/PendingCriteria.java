package services.apiFilter;

import models.Api;
import scala.concurrent.java8.FuturesConvertersImpl;
import services.apiStates.ApiStates;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class PendingCriteria implements ApiStateCriteria {
    @Override
    public List<Api> meetCriteria(List<Api> apis) {
        List<Api> pendingApis = new ArrayList<>();

        // Iterate through all APIs and add them to the pending APIs according to their state
        Iterator<Api> apiIterator = apis.iterator();
        while (apiIterator.hasNext()) {
            Api api = apiIterator.next();
            if (api.getState() == ApiStates.PENDING) {
                pendingApis.add(api);
            }
        }

        return pendingApis;
    }
}
