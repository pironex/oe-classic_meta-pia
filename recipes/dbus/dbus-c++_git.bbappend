THISDIR := "${@os.path.dirname(bb.data.getVar('FILE', d, True))}"
FILESPATHBASE_prepend := "${THISDIR}/dbus-c++:"

#SRCREV = "9e25833870ed8281fab00d7f9eac5755c6798c57"
# 0.9.0 release version
SRCREV = "1f6f3e6e966e0b453edc4a82338dc27966c37505"

PR_append = "+pia012"
PV = "0.9.0+gitr${SRCREV}"

SRC_URI_append = " file://add_unistd_header.patch"

DEPENDS += " dbus "

EXTRA_OECONF = " \
  --disable-ecore \
  --disable-examples \
  --disable-tests "

EXTRA_OECONF_virtclass-sdk = " \
  --disable-ecore \
  --disable-examples \
  --disable-tests \
  'glib_CFLAGS=-I${STAGING_DIR}/${HOST_SYS}${target_includedir} -I${STAGING_DIR}/${HOST_SYS}${target_includedir}/glib-2.0 -I${STAGING_DIR}/${HOST_SYS}${target_libdir}/glib-2.0/include'\
  'dbus_CFLAGS=-I${STAGING_DIR}/${HOST_SYS}${target_includedir} -I${STAGING_DIR}/${HOST_SYS}${target_includedir}/dbus-1.0 -I${STAGING_DIR}/${HOST_SYS}${target_libdir}/dbus-1.0/include'\
  "

BBCLASSEXTEND = "native sdk"
