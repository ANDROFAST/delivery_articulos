package com.google.android.gms.nearby.messages;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;

public interface Messages {
    PendingResult<Status> getPermissionStatus(GoogleApiClient googleApiClient);

    PendingResult<Status> publish(GoogleApiClient googleApiClient, Message message);

    PendingResult<Status> publish(GoogleApiClient googleApiClient, Message message, PublishOptions publishOptions);

    @Deprecated
    PendingResult<Status> publish(GoogleApiClient googleApiClient, Message message, Strategy strategy);

    PendingResult<Status> registerStatusCallback(GoogleApiClient googleApiClient, StatusCallback statusCallback);

    PendingResult<Status> subscribe(GoogleApiClient googleApiClient, MessageListener messageListener);

    @Deprecated
    PendingResult<Status> subscribe(GoogleApiClient googleApiClient, MessageListener messageListener, Strategy strategy);

    @Deprecated
    PendingResult<Status> subscribe(GoogleApiClient googleApiClient, MessageListener messageListener, Strategy strategy, MessageFilter messageFilter);

    PendingResult<Status> subscribe(GoogleApiClient googleApiClient, MessageListener messageListener, SubscribeOptions subscribeOptions);

    PendingResult<Status> unpublish(GoogleApiClient googleApiClient, Message message);

    PendingResult<Status> unregisterStatusCallback(GoogleApiClient googleApiClient, StatusCallback statusCallback);

    PendingResult<Status> unsubscribe(GoogleApiClient googleApiClient, MessageListener messageListener);
}
