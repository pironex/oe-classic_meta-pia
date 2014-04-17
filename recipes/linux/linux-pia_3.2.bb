require linux.inc
DESCRIPTION = "Linux kernel for OMAP processors"
KERNEL_IMAGETYPE = "uImage"

COMPATIBLE_MACHINE_pia-am35x = "pia-am35x"

PV = "3.2.54"
#SRCREV = "6696c75a499ac4fc586a47f2c73d2351844e21bd"
# 2012-02
#SRCREV = "46de1f56694734a26cd0dd50f5debb1467c97600"
# 2012-04
#SRCREV = "b79b867af312a498ef26dca52f4333a19b3c93b6"
# 2012-05 EMS patches
#SRCREV = "684a638e2f4c80c55f44d5e52a3e12f843ea4e90"
# 2012-06
#SRCREV = "3044edadc4435da35ad540e7709e4b2add908d8c"
#MACHINE_KERNEL_PR_append = "pia013+gitr${SRCREV}"
# 2012-06a kako io changes
#SRCREV = "fab625c6d2ae9c0885d6a08495166f6ea37152d1"
# bugfixes + CMUX
#SRCREV = "1d29c6909cd7b5eb2c4fd8d652a977145f8c2fcd"
#MACHINE_KERNEL_PR_append = "pia018+gitr${SRCREV}"
# KACO fixes RS485
PREFERRED_PROVIDER_virtual/kernel = "linux-pia-kaco"
#SRCREV = "514ef252d8e5d6ab113b3d1664ed3bbbc70bd978"
#MACHINE_KERNEL_PR_append = "pia019+gitr${SRCREV}"
#SRCREV = "135789084f0bf303771170a8728d1b946ee8a92d"
#MACHINE_KERNEL_PR_append = "pia021+gitr${SRCREV}"
# MUSB fixes
#SRCREV = "8a727c75ed3d0abc59f864181f0d22ef381cdf87"
#MACHINE_KERNEL_PR_append = "pia022+gitr${SRCREV}"
# I2C adapter classes fix
SRCREV = "027eb7d3ce8458c9a05ab12c54329f575a4acb69"
MACHINE_KERNEL_PR_append = "pia023+gitr${SRCREV}"



# workaround for older OE:
THISDIR := "${@os.path.dirname(bb.data.getVar('FILE', d, True))}"
FILESPATHPKG_prepend := "config-3.2:"
#FILESPATHBASE_prepend := "${THISDIR}/config:${THISDIR}/patches:"
# add out config files path to the search path
# this works only for oe-core (new layered OE)
#FILESEXTRAPATHS := "${THISDIR}/${PN}"
#FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI = "git://192.168.1.90/kernel/linux-pia-bk.git;branch=pia35x-3.2-dev;protocol=git \
           file://defconfig \
           file://files/logo_linux_clut224.ppm \
"

#module_autoload_g_serial = "g_serial"

#SRC_URI_append_pia-am35x = "\
#    file://patches/0001-master_to_pia_testing_ems.patch "

#S = "${WORKDIR}/linux-omap-2.6"
S = "${WORKDIR}/git"

do_configure_prepend() {
	cp ${WORKDIR}/files/logo_linux_clut224.ppm ${WORKDIR}/git/drivers/video/logo/ 
}

do_install_append() {
	#
	# Copy the entire source tree. In case an external build directory is
	# used, copy the build directory over first, then copy over the source
	# dir. This ensures the original Makefiles are used and not the
	# redirecting Makefiles in the build directory.
	#
	# work and sysroots can be on different partitions, so we can't rely on
	# hardlinking, unfortunately.
	#
	find . -depth -not -name "*.cmd" -not -name "*.o" -not -path "./.*" -print0 | cpio --null -pdu $kerneldir
	cp .config $kerneldir
	if [ "${S}" != "${B}" ]; then
		pwd="$PWD"
		cd "${S}"
		find . -depth -not -path "./.*" -print0 | cpio --null -pdu $kerneldir
		cd "$pwd"
	fi
	install -m 0644 ${KERNEL_OUTPUT} $kerneldir/${KERNEL_IMAGETYPE}
	install -m 0644 System.map $kerneldir/System.map-${KERNEL_VERSION}
	cp -fR ${D}/kernel ${STAGING_KERNEL_DIR}
}

sysroot_stage_all_append() {
	sysroot_stage_dir ${D}/kernel ${SYSROOT_DESTDIR}
}