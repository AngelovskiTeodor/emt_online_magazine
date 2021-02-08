package mk.ukim.finki.emt.onlinemagazine.sharedkernel.infrastructure.eventlog;

import mk.ukim.finki.emt.onlinemagazine.sharedkernel.domain.base.RemoteEventLog;

public interface RemoteEventLogService  {

    String source();

    RemoteEventLog currentLog(long lastProcessedId);

}
