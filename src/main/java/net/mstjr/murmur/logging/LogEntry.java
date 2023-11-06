//
// Copyright (c) ZeroC, Inc. All rights reserved.
//
//
// Ice version 3.7.9
//
// <auto-generated>
//
// Generated from file `Murmur.ice'
//
// Warning: do not edit this file.
//
// </auto-generated>
//

package net.mstjr.murmur.logging;

/**
 * A entry in the log.
 **/
public class LogEntry implements Cloneable,
                                 java.io.Serializable
{
    /**
     * Timestamp in UNIX time_t
     **/
    public int timestamp;

    /**
     * The log message.
     **/
    public String txt;

    public LogEntry()
    {
        this.txt = "";
    }

    public LogEntry(int timestamp, String txt)
    {
        this.timestamp = timestamp;
        this.txt = txt;
    }

    public boolean equals(Object rhs)
    {
        if(this == rhs)
        {
            return true;
        }
        LogEntry r = null;
        if(rhs instanceof LogEntry)
        {
            r = (LogEntry)rhs;
        }

        if(r != null)
        {
            if(this.timestamp != r.timestamp)
            {
                return false;
            }
            if(this.txt != r.txt)
            {
                return this.txt != null && r.txt != null && this.txt.equals(r.txt);
            }

            return true;
        }

        return false;
    }

    public int hashCode()
    {
        int h_ = 5381;
        h_ = com.zeroc.IceInternal.HashUtil.hashAdd(h_, "::Murmur::LogEntry");
        h_ = com.zeroc.IceInternal.HashUtil.hashAdd(h_, timestamp);
        h_ = com.zeroc.IceInternal.HashUtil.hashAdd(h_, txt);
        return h_;
    }

    public LogEntry clone()
    {
        LogEntry c = null;
        try
        {
            c = (LogEntry)super.clone();
        }
        catch(CloneNotSupportedException ex)
        {
            assert false; // impossible
        }
        return c;
    }

    public void ice_writeMembers(com.zeroc.Ice.OutputStream ostr)
    {
        ostr.writeInt(this.timestamp);
        ostr.writeString(this.txt);
    }

    public void ice_readMembers(com.zeroc.Ice.InputStream istr)
    {
        this.timestamp = istr.readInt();
        this.txt = istr.readString();
    }

    static public void ice_write(com.zeroc.Ice.OutputStream ostr, LogEntry v)
    {
        if(v == null)
        {
            _nullMarshalValue.ice_writeMembers(ostr);
        }
        else
        {
            v.ice_writeMembers(ostr);
        }
    }

    static public LogEntry ice_read(com.zeroc.Ice.InputStream istr)
    {
        LogEntry v = new LogEntry();
        v.ice_readMembers(istr);
        return v;
    }

    static public void ice_write(com.zeroc.Ice.OutputStream ostr, int tag, java.util.Optional<LogEntry> v)
    {
        if(v != null && v.isPresent())
        {
            ice_write(ostr, tag, v.get());
        }
    }

    static public void ice_write(com.zeroc.Ice.OutputStream ostr, int tag, LogEntry v)
    {
        if(ostr.writeOptional(tag, com.zeroc.Ice.OptionalFormat.FSize))
        {
            int pos = ostr.startSize();
            ice_write(ostr, v);
            ostr.endSize(pos);
        }
    }

    static public java.util.Optional<LogEntry> ice_read(com.zeroc.Ice.InputStream istr, int tag)
    {
        if(istr.readOptional(tag, com.zeroc.Ice.OptionalFormat.FSize))
        {
            istr.skip(4);
            return java.util.Optional.of(LogEntry.ice_read(istr));
        }
        else
        {
            return java.util.Optional.empty();
        }
    }

    private static final LogEntry _nullMarshalValue = new LogEntry();

    /** @hidden */
    public static final long serialVersionUID = -97681107L;
}