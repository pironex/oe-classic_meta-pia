THISDIR := "${@os.path.dirname(bb.data.getVar('FILE', d, True))}"
FILESPATHBASE_prepend := "${THISDIR}/dbus-c++:"

PR_append = "+pia001"

BBCLASSEXTEND = "native sdk"
