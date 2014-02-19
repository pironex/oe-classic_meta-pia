#!/bin/sh

if [ -e /dev/input/touchscreen0 ]
then
    QWS_MOUSE_PROTO=tslib
    export QWS_MOUSE_PROTO
fi
