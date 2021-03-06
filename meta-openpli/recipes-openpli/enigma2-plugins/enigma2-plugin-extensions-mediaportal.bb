DESCRIPTION = "MediaPortal "
RDEPENDS_${PN} = "python-compression python-robotparser python-mechanize python-json python-html gst-plugins-good-flv gst-plugins-bad-rtmp librtmp1 rtmpdump"
MAINTAINER = "dhwz"
LICENSE = "proprietary"

DEPENDS = "python"

require conf/license/openpli-gplv2.inc

inherit gitpkgv autotools pythonnative

SRCREV = "${AUTOREV}"
PV = "5.0.6+git${SRCPV}"
PKGV = "5.0.6+git${GITPKGV}"
PR = "r2"

#SRC_URI = "https://github.com/dhwz/trash/archive/4.9.2.tar.gz file://fix_build.patch"
SRC_URI = "git://github.com/OpenAR-P/MediaPortal;protocol=git "

S = "${WORKDIR}/git"

EXTRA_OECONF = " \
	BUILD_SYS=${BUILD_SYS} \
	HOST_SYS=${HOST_SYS} \
	STAGING_INCDIR=${STAGING_INCDIR} \
	STAGING_LIBDIR=${STAGING_LIBDIR} \
	"

FILES_${PN}_append += "/"
FILES_${PN}-src_append += "${libdir}/enigma2/python/Components/Converter/MPServicePosition.py"

pkg_postinst_${PN} () {
#!/bin/sh
echo "********************************************************"
echo "*  MediaPortal installed                               *"
echo "*                                                      *"
echo "*  Restart the Engima2 GUI to activate the plugin      *"
echo "********************************************************"
exit 0
}

pkg_postrm_${PN} () {
#!/bin/sh
echo "Removing MediaPortal Plugin from the system ..."
rm -rf /usr/lib/enigma2/python/Plugins/Extensions/MediaPortal > /dev/null 2>&1
exit 0
}

pkg_preinst_${PN} () {
#!/bin/sh
echo "Checking for an older version of MediaPortal in the system..."
if [ -d /usr/lib/enigma2/python/Plugins/Extensions/mediaportal ]
then
rm -rf /usr/lib/enigma2/python/Plugins/Extensions/mediaportal > /dev/null 2>&1
echo "An older version of MediaPortal was found and removed"
echo "Proceeding to installation..."
elif [ -d /usr/lib/enigma2/python/Plugins/Extensions/MediaPortal ]
then
rm -rf /usr/lib/enigma2/python/Plugins/Extensions/MediaPortal > /dev/null 2>&1
echo "An older version of MediaPortal was found and removed"
echo "Proceeding to installation..."
else
echo "MediaPortal was not found in the system"
echo "Proceeding to installation..."
fi
exit 0
}
