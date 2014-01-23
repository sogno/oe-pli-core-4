DESCRIPTION = "OE-A Branding Lib for OE-A 2.0"
MAINTAINER = "oe-alliance team"
PACKAGE_ARCH = "${MACHINE_ARCH}"

DEPENDS = "python"

require conf/license/openpli-gplv2.inc

inherit gitpkgv autotools pythonnative

PACKAGES += " ${PN}-src"

SRCREV = "${AUTOREV}"
PV = "0.3+git${SRCPV}"
PKGV = "0.3+git${GITPKGV}"
PR = "r16"

SRC_URI="git://github.com/oe-alliance/branding-module.git;protocol=git"

S = "${WORKDIR}/git"

EXTRA_OECONF = " \
    BUILD_SYS=${BUILD_SYS} \
    HOST_SYS=${HOST_SYS} \
    STAGING_INCDIR=${STAGING_INCDIR} \
    STAGING_LIBDIR=${STAGING_LIBDIR} \
    --with-distro=${DISTRO_NAME} \
    --with-boxtype=${MACHINEBUILD} \
    --with-machineoem="${MACHINE_OEM}" \
    --with-machinebrand="${MACHINE_BRAND}" \
    --with-machinename="${MACHINE_NAME}" \
    --with-imageversion=${DISTRO_VERSION} \
    --with-imagebuild=${BUILD_VERSION} \
    --with-driverdate=${DRIVERSDATE} \
    "

do_configure_prepend() {
    if [ "${MACHINE}" = "sogno8800hd" ]; then
        DRIVERSDATE=`grep "SRCDATE = " ${OE-ALLIANCE_BASE}/meta-oe-alliance/recipes-bsp/sogno/sogno-dvb-modules-${MACHINE}.bb | cut -b 12-19`
    else
        DRIVERSDATE='N/A'
    fi
}

FILES_${PN}-src = "${libdir}/enigma2/python/Components/*.py"
FILES_${PN} = "${libdir}/enigma2/python/*.so /usr/share ${libdir}/enigma2/python/Components/*.pyo ${libdir}/enigma2/python/Plugins"
FILES_${PN}-dev += "${libdir}/enigma2/python/*.la"
FILES_${PN}-staticdev += "${libdir}/enigma2/python/*.a"
FILES_${PN}-dbg += "${libdir}/enigma2/python/.debug"

