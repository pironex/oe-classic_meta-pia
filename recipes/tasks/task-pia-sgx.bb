DESCRIPTION = "Support for 3D-Graphics on piAx"
LICENSE = "MIT"
PR = "r001"

inherit task

RDEPENDS = ' \
	omap3-sgx-modules libgles-omap3-tests libgles-omap3-rawdemos \
'

# packages required for expansion boards, display
RRECOMMENDS = ' \
'
# 	kernel-modules