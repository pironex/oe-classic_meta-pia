DESCRIPTION = "Additional packages for KACO EMS images"
LICENSE = "MIT"
PR = "r005"

inherit task

RDEPENDS = ' \
	psplash-kaco \
'
#		udev-extra-rules 

# packages required for expansion boards, display
RRECOMMENDS = ' \
    bash \
    sqlite3 \
    usbutils \
'
