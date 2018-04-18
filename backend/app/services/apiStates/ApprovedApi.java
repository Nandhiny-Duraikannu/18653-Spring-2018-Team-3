package services.apiStates;

import models.Api;

public class ApprovedApi implements ApiState {
    @Override
    public void updateApiState(Api api) {
        api.setState(ApiStates.APPROVED);
    }
}
