require libtool-${PV}.inc
PR = "${INC_PR}.1"

DEFAULT_PREFERENCE = "-1"

SRC_URI_append = " file://prefix.patch \
                   file://fixinstall.patch \
                 "
DEPENDS += "libtool-native"

do_configure_prepend () {
        # Remove any existing libtool m4 since old stale versions would break
        # any upgrade
        rm -f ${STAGING_DATADIR}/aclocal/libtool.m4
        rm -f ${STAGING_DATADIR}/aclocal/lt*.m4
}

do_install () {
        install -d ${D}${bindir}/
        install -m 0755 ${HOST_SYS}-libtool ${D}${bindir}/${HOST_SYS}-libtool
        install -d ${D}${datadir}/libtool/
        install -d ${D}${datadir}/libtool/config
        install -d ${D}${datadir}/aclocal/
        install -c ${S}/libltdl/config/config.guess ${D}${datadir}/libtool/config/
        install -c ${S}/libltdl/config/config.sub ${D}${datadir}/libtool/config/
        install -c -m 0644 ${S}/libltdl/config/ltmain.sh ${D}${datadir}/libtool/config/
        install -c -m 0644 ${S}/libltdl/m4/libtool.m4 ${D}${datadir}/aclocal/
        install -c -m 0644 ${S}/libltdl/m4/ltdl.m4 ${D}${datadir}/aclocal/
}

SYSROOT_PREPROCESS_FUNCS += "libtoolcross_sysroot_preprocess"

libtoolcross_sysroot_preprocess () {
        install -d ${SYSROOT_DESTDIR}${STAGING_BINDIR_CROSS}/
        install -m 755 ${D}${bindir}/${HOST_SYS}-libtool ${SYSROOT_DESTDIR}${STAGING_BINDIR_CROSS}/${HOST_SYS}-libtool
}
NATIVE_INSTALL_WORKS = "1"
