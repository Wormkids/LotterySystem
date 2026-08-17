package com.xzj.lotterysystem.common.filter;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.filter.Filter;
import ch.qos.logback.core.spi.FilterReply;
import org.slf4j.event.Level;

import javax.xml.crypto.dsig.spec.XPathType;

public class InfoLevelFilter extends Filter<ILoggingEvent> {
    @Override
    public FilterReply decide(ILoggingEvent iLoggingEvent)
    {
        if (iLoggingEvent.getLevel().toInt() == Level.INFO.toInt())
        {
            return  FilterReply.ACCEPT;
        }
        return FilterReply.DENY;
    }
}
