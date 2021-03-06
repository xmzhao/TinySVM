%define prefix /usr
%define version 0.09

Summary: TinySVM is a small and fast SVM package
Name: TinySVM
Version: %{version}
Release: 1
Copyright: LGPL
Group: local
Packager: Taku Kudoh <taku-ku@is.aist-nara.ac.jp>
Source: %{name}-%{version}.tar.gz
BuildRoot: /var/tmp/TinySVM

%description
TinySVM is a small and fast SVM package

%package devel
Summary: Libraries and header files for TinySVM
Group: Development/Libraries
Requires: TinySVM = %{version}

%package perl
Summary: TinySVM Perl Module
Group: Development/Libraries
Requires: perl >= 5.6 TinySVM = %{version}

%description devel
Libraries and header files for TinySVM

%description perl
TinySVM Perl Module

%prep

%setup

%build
./configure --prefix=%{prefix}
make CFLAGS="$RPM_OPT_FLAGS"

cd src
ln -s . TinySVM
cd ../perl
perl Makefile.PL
make INC="-I../src -I%{prefix}/include -I/usr/include" LCFLAGS="$RPM_OPT_FLAGS" LDDLFLAGS="-shared -Wl,-rpath -Wl,%{prefix}/lib -L../src/.libs -ltinysvm"
cd ..
rm -f src/TinySVM

%install
make prefix=$RPM_BUILD_ROOT%{prefix} install

cd perl
make PREFIX=$RPM_BUILD_ROOT%{prefix} INSTALLMAN3DIR=$RPM_BUILD_ROOT%{prefix}/man/man3 install
cd ..

%clean
rm -rf $RPM_BUILD_ROOT

%files
%defattr(-, root, root)
%doc doc/*.html doc/*.css
%{prefix}/lib/*.so.*
%{prefix}/bin/*
%{prefix}/man/man1/*

%files devel
%defattr(-, root, root)
%{prefix}/include/*
%{prefix}/lib/*.so
%{prefix}/lib/*.a
%{prefix}/lib/*.la

%files perl
%defattr(-, root, root)
%{prefix}/lib/perl5/site_perl/*


