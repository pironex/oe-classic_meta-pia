DESCRIPTION = "Extra udev rules"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=3f40d7994397109285ec7b81fdeb3b58"

#inherit allarch
PACKAGE_ARCH = "all"

# No need for virtual/libc or a cross compiler
INHIBIT_DEFAULT_DEPS = "1"

# Set these to a common set of values, we shouldn't be using them other that for WORKDIR directory
# naming anyway
#TARGET_ARCH = "allarch"
TARGET_OS = "linux"
TARGET_CC_ARCH = "none"
TARGET_LD_ARCH = "none"
TARGET_AS_ARCH = "none"
PACKAGE_EXTRA_ARCHS = ""

# No need to do shared library processing or debug symbol handling
EXCLUDE_FROM_SHLIBS = "1"
INHIBIT_PACKAGE_DEBUG_SPLIT = "1"
INHIBIT_PACKAGE_STRIP = "1"

PR = "r3"

SRC_URI = " \
       file://automount.rules \
       file://mount.sh \
       file://mount.blacklist \
       file://autonet.rules \
       file://network.sh \
       file://local.rules \
"


do_install() {
	install -d ${D}${sysconfdir}/udev/rules.d

    install -m 0644 ${WORKDIR}/automount.rules     ${D}${sysconfdir}/udev/rules.d/automount.rules
    install -m 0644 ${WORKDIR}/autonet.rules       ${D}${sysconfdir}/udev/rules.d/autonet.rules
    install -m 0644 ${WORKDIR}/local.rules         ${D}${sysconfdir}/udev/rules.d/local.rules

    install -m 0644 ${WORKDIR}/mount.blacklist     ${D}${sysconfdir}/udev/

    install -d ${D}${sysconfdir}/udev/scripts/

    install -m 0755 ${WORKDIR}/mount.sh ${D}${sysconfdir}/udev/scripts/mount.sh
    install -m 0755 ${WORKDIR}/network.sh ${D}${sysconfdir}/udev/scripts
}

FILES_${PN} = "${sysconfdir}/udev"
RDEPENDS_${PN} = "udev"
