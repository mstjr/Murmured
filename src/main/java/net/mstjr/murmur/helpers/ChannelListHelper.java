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

package net.mstjr.murmur.helpers;

import net.mstjr.murmur.proxy.server.channel.Channel;

/**
 * Helper class for marshaling/unmarshaling ChannelList.
 **/
public final class ChannelListHelper
{
    public static void write(com.zeroc.Ice.OutputStream ostr, Channel[] v)
    {
        if(v == null)
        {
            ostr.writeSize(0);
        }
        else
        {
            ostr.writeSize(v.length);
            for(int i0 = 0; i0 < v.length; i0++)
            {
                Channel.ice_write(ostr, v[i0]);
            }
        }
    }

    public static Channel[] read(com.zeroc.Ice.InputStream istr)
    {
        final Channel[] v;
        final int len0 = istr.readAndCheckSeqSize(16);
        v = new Channel[len0];
        for(int i0 = 0; i0 < len0; i0++)
        {
            v[i0] = Channel.ice_read(istr);
        }
        return v;
    }

    public static void write(com.zeroc.Ice.OutputStream ostr, int tag, java.util.Optional<Channel[]> v)
    {
        if(v != null && v.isPresent())
        {
            write(ostr, tag, v.get());
        }
    }

    public static void write(com.zeroc.Ice.OutputStream ostr, int tag, Channel[] v)
    {
        if(ostr.writeOptional(tag, com.zeroc.Ice.OptionalFormat.FSize))
        {
            int pos = ostr.startSize();
            ChannelListHelper.write(ostr, v);
            ostr.endSize(pos);
        }
    }

    public static java.util.Optional<Channel[]> read(com.zeroc.Ice.InputStream istr, int tag)
    {
        if(istr.readOptional(tag, com.zeroc.Ice.OptionalFormat.FSize))
        {
            istr.skip(4);
            Channel[] v;
            v = ChannelListHelper.read(istr);
            return java.util.Optional.of(v);
        }
        else
        {
            return java.util.Optional.empty();
        }
    }
}
