PR_append = "+pia001"

THISDIR := "${@os.path.dirname(bb.data.getVar('FILE', d, True))}"
FILESPATHBASE_prepend := "${THISDIR}:"

# You can create your own pslash-poky-img.h by doing
# ./make-image-header.sh <file>.png POKY
# and rename the resulting .h to pslash-poky-img.h (for the logo)
# respectively psplash-bar-img.h (BAR) for the bar.
# You might also want to patch the colors (see patch)
