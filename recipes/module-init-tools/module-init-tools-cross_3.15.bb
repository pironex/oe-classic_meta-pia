require module-init-tools.inc
inherit cross
SRC_URI = "${KERNELORG_MIRROR}/pub/linux/utils/kernel/module-init-tools/module-init-tools-${PV}.tar.bz2"
EXTRA_OECONF += "--disable-builddir"
#DEPENDS += "docbook-utils-native"

DEFAULT_PREFERENCE = "0"
PROVIDES += "virtual/${TARGET_PREFIX}depmod virtual/${TARGET_PREFIX}depmod-2.6 virtual/${TARGET_PREFIX}depmod-3.2"

# Remove the RDEPENDS_${PN} we picked up from the "require";
# it's simply extraneous for the cross package
RDEPENDS_${PN} = ""

EXTRA_OECONF_append = " --program-prefix=${TARGET_PREFIX}"

do_install_append () {
        mv ${D}${bindir}/${TARGET_PREFIX}depmod ${D}${bindir}/${TARGET_PREFIX}depmod-2.6
}

do_configure_prepend() {
	sed -i -e /MAN5\ =/d -e /MAN8\ =/d Makefile.am 
}

SRC_URI[md5sum] = "04f04e6f976f46c89523679c452a0324"
SRC_URI[sha256sum] = "fd448d0ed037f7d13cbcac8f22c93818e4518d984b4fe2edeaaeaaf262ec99a9"
