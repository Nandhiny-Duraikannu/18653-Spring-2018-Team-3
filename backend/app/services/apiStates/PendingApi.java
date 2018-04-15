package services.apiStates;

import models.Api;

public class PendingApi implements ApiState {
    @Override
    public void updateApiState(Api api) {
        api.setState(ApiStates.PENDING);
    }
}
