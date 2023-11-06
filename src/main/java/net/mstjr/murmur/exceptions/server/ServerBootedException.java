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

package net.mstjr.murmur.exceptions.server;

import net.mstjr.murmur.exceptions.MurmurException;

/**
 * This happens if you try to fetch user or channel state on a stopped server, if you try to stop an already stopped server or start an already started server.
 **/
public class ServerBootedException extends MurmurException
{
    public ServerBootedException()
    {
        super();
    }

    public ServerBootedException(Throwable cause)
    {
        super(cause);
    }

    public String ice_id()
    {
        return "::Murmur::ServerBootedException";
    }

    /** @hidden */
    @Override
    protected void _writeImpl(com.zeroc.Ice.OutputStream ostr_)
    {
        ostr_.startSlice("::Murmur::ServerBootedException", -1, false);
        ostr_.endSlice();
        super._writeImpl(ostr_);
    }

    /** @hidden */
    @Override
    protected void _readImpl(com.zeroc.Ice.InputStream istr_)
    {
        istr_.startSlice();
        istr_.endSlice();
        super._readImpl(istr_);
    }

    /** @hidden */
    public static final long serialVersionUID = 214446146L;
}
