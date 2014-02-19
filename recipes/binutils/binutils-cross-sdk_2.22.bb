require binutils_${PV}.bb
require binutils-cross-sdk.inc

#inherit crosssdk
#
#PROVIDES = "virtual/${TARGET_PREFIX}binutils-cross-sdk"
#

do_configure_prepend () {
	sed -i 's#/usr/local/lib /lib /usr/lib#${SDKPATHNATIVE}/lib ${SDKPATHNATIVE}/usr/lib /usr/local/lib /lib /usr/lib#' ${S}/ld/configure.tgt
}

