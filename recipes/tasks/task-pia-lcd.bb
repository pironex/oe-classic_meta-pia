DESCRIPTION = "Packages for 2D graphical output."
LICENSE = "MIT"
PR = "r002"

inherit task

RDEPENDS = ' \
'

# packages required for expansion boards, display
RDEPENDS = ' \
	omapfbplay lame mplayer \
	tslib-conf tslib-calibrate \
	pia-display-tools \
'
# 	kernel-modules