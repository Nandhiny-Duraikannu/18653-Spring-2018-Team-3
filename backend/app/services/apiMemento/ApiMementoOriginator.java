package services.apiMemento;

import models.Api;

public class ApiMementoOriginator {

    private Api state;

    public void setState (Api api) {
        this.state = api;
    }

    public Api getState () {
        return this.state;
    }

    public ApiMemento save (Api apiToSave) {
        this.setState(apiToSave);
        return new ApiMemento(apiToSave);
    }

    public void restoreFromMemento (ApiMemento memento) {
        this.state = memento.getState();
    }
}
