from setuptools import setup, find_packages

setup(name='frequency',
      version='1.0.0',
      description='Decrypts encrypted text using a frequency attack.',
      author='Conor Murphy',
      author_email='ctmurphy@pipeline.sbcc.edu',
      packages=find_packages(),
      entry_points={
          'console_scripts': ['frequency=frequency.__main__:main'],
      },
      license="AGPL-3.0-or-later",
      zip_safe=False)
